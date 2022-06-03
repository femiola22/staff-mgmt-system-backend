package com.femio.staff.controller;

import com.femio.staff.model.Staff;
import com.femio.staff.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/staffs")
    public Staff createStaff(@RequestBody Staff staff) {
        return staffService.createStaff(staff);
    }

    @GetMapping("/staffs")
    public List<Staff> getAllStaffs() {
        return staffService.getAllStaffs();
    }

    @DeleteMapping("/staffs/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStaff(@PathVariable Long id) {
        boolean deleted = staffService.deleteStaff(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/staffs/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        Staff staff = null;
        staff = staffService.getStaffById(id);
        return ResponseEntity.ok(staff);
    }

    @PutMapping("/staffs/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id,
                                                @RequestBody Staff staff) {
        staff = staffService.updateStaff(id, staff);
        return   ResponseEntity.ok(staff);
    }
}
