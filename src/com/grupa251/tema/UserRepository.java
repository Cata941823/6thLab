package com.grupa251.tema;

import java.util.ArrayList;

public interface UserRepository {
    User FindById(long ID);
    ArrayList<User> Returnare();
    User Login(long ID, String Password);
}
