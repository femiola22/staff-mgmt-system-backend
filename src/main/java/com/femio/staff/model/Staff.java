package com.femio.staff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
