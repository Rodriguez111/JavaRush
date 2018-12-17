package com.javarush.task.task11.task1105;

/* 
ИТ-компания
*/

public class Solution {
    public  void main(String[] args) {
        Worker w=new Worker();
        w.run();



    }

    public class Worker {

        public int run(){return 0;}

    }

    public class Clerk extends Worker {

    }

    public class IT extends Worker {

    }

    public class Programmer extends IT {


    }

    public class ProjectManager extends IT {

    }

    public class CTO extends IT {

    }

    public class OfficeManager extends Clerk {

    }

    public class HR extends Clerk {

    }

    public class Cleaner extends Clerk {

    }
}
