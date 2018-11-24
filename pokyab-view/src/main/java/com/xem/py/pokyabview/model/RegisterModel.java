
package com.xem.py.pokyabview.model;

import com.xem.py.pokyabmodel.dto.User;
import java.io.Serializable;

/**
 *
 * @author arria
 */
public class RegisterModel implements  Serializable{
    private static final long serialVersionUID = 1L;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
