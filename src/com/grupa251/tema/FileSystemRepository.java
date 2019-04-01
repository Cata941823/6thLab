package com.grupa251.tema;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileSystemRepository implements UserRepository{

    private File path;
    private ArrayList<User> useri = new ArrayList<>();
    private User x = new User();

    public ArrayList<User> filterByUserType(UserType usertype)
    {
        ArrayList<User> toAdd = new ArrayList<>();
        User Y = new User();
        for(int i = 0; i<useri.size(); i++)
        {
            Y = useri.get(i);
            if(Y.getTip().equals(usertype))
                toAdd.add(Y);
        }
        return toAdd;
    }

    public FileSystemRepository(File path) throws FileNotFoundException {
        Scanner scanner = new Scanner(path);
        while(scanner.hasNextLine()){
            x.setNume(scanner.next());
            x.setPrenume(scanner.next());
            x.setID(scanner.nextLong());
            x.setParola(scanner.next());
            String a = scanner.next();
            if(a.equals("ADMIN")) x.setTip(UserType.ADMIN);
            if(a.equals("SUPER_ADMIN")) x.setTip(UserType.SUPER_ADMIN);
            if(a.equals("SIMPLE_USER")) x.setTip((UserType.SIMPLE_USER));
            useri.add(x);
            x = new User();
        }
    }

    @Override
    public User FindById(long ID) {
        User X = new User();
        for(int i = 0; i<useri.size(); i++)
        {
            X = useri.get(i);
            if(X.getID() == ID)
                break;
        }
        if(X.getID()==ID)
        {
            System.out.println("Successfully match!\n" + X);
            return X;
        }
        else
        {
            System.out.println("This item could not match!");
            return null;
        }
    }

    @Override
    public ArrayList<User> Returnare() {
        for(int i = 0; i<useri.size(); i++)
            System.out.println(useri.get(i));
        return useri;
    }

    @Override
    public User Login(long ID, String Password) {
        User X = new User();
        for(int i = 0; i<useri.size(); i++)
        {
            X = useri.get(i);
            if(X.getID() == ID && X.getParola().equals(Password))
            {
                System.out.print("Success login: ");
                System.out.println(X);
                break;
            }
        }
        if(X.getID()==ID) return X;
        else
        {
            System.out.println("The items could not match!");
            return null;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Cata\\Desktop\\JavaPrograms\\Challenge\\src\\com\\grupa251\\tema\\Accounts");
        FileSystemRepository A = new FileSystemRepository(file);
        A.FindById(25);
        System.out.println();
        A.Returnare();
        System.out.println();
        A.Login(2,"adidas");
        UserType test = UserType.SIMPLE_USER;
        System.out.println(A.filterByUserType(test));

    }
}
