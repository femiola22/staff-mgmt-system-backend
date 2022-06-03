package com.femio.staff.service;

import com.femio.staff.entity.StaffEntity;
import com.femio.staff.model.Staff;
import com.femio.staff.repository.StaffRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffServiceImplementation implements StaffService {

    private final StaffRepository staffRepository;

    public StaffServiceImplementation(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff createStaff(Staff staff) {
        StaffEntity staffEntity = new StaffEntity();
        BeanUtils.copyProperties(staff, staffEntity);
        staffRepository.save(staffEntity);
        return staff;
    }

    @Override
    public List<Staff> getAllStaffs() {
        List<StaffEntity> staffEntities
                = staffRepository.findAll();

        List<Staff> staff = staffEntities
                .stream()
                .map(emp -> new Staff(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()
                ))
                .collect(Collectors.toList());

        return staff;
    }

    @Override
    public boolean deleteStaff(Long id) {
        StaffEntity staff = staffRepository.findById(id).get();
        staffRepository.delete(staff);
        return true;
    }

    @Override
    public Staff getStaffById(Long id) {
        StaffEntity staffEntity = staffRepository.findById(id).get();
        Staff staff = new Staff();
        BeanUtils.copyProperties(staffEntity, staff);
        return staff;
    }

    @Override
    public Staff updateStaff(Long id, Staff staff) {
        StaffEntity staffEntity = staffRepository.findById(id).get();
        staffEntity.setEmailId(staff.getEmailId());
        staffEntity.setFirstName(staff.getFirstName());
        staffEntity.setLastName(staff.getLastName());

        staffRepository.save(staffEntity);
        return staff;
    }
}
