package com.femio.staff.service;

import com.femio.staff.model.Staff;

import java.util.List;

public interface StaffService {
    Staff createStaff(Staff staff);

    List<Staff> getAllStaffs();

    boolean deleteStaff(Long id);

    Staff getStaffById(Long id);

    Staff updateStaff(Long id, Staff staff);
}
