package com.osfocus.www.basic.c08;

import java.util.ArrayList;
import java.util.List;

// Get the maximum happy number from all possible outcome of employees attending a party
// when an employee attends the party, his/her director subordinates can't go to the party
// Bottom-up approach counting all possible attend and not attend outcome, and find out the max number
public class C06_MaxHappy {
    public static class Employee {
        public int happy;
        public List<Employee> subordinates;

        public Employee(int happy) {
            this.happy = happy;
            subordinates = new ArrayList<>();
        }
    }

    public static class Info {
        public int yes; // employee attends the party
        public int no; // employee does not attend the party

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }

    public static int getMaxHappy(Employee boss) {
        Info info = process1(boss);
        return Math.max(info.yes, info.no);
    }

    private static Info process1(Employee curEmployee) {
        if (curEmployee.subordinates.isEmpty()) return new Info(curEmployee.happy, 0);

        // sum up all yes and no output
        int yes = curEmployee.happy;
        int no = 0;

        for (Employee e : curEmployee.subordinates) {
            Info tmpInfo = process1(e);
            yes += tmpInfo.no;
            no += Math.max(tmpInfo.yes, tmpInfo.no);
        }

        return new Info(yes, no);
    }
}
