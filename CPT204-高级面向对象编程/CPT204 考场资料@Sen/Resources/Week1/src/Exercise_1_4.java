public class Exercise_1_4 {
    public static class Student {
        private float firstName;
        private float lastName;
        private float emailAddress;
        private int groupID;

        public Student(float firstName, float lastName, float emailAddress, int groupID) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.emailAddress = emailAddress;
            this.groupID = groupID;
        }

        public String toString(){
            return "Student: " + firstName + " " + lastName + " " + emailAddress + " " + groupID;
        }
        public void less(Student other){
            if (this.groupID > other.groupID){
                System.out.println("This student is bigger");
            }
            else if (this.groupID < other.groupID){
                System.out.println("This student is smaller");
            }
            else {
                System.out.println("They are equal");
            }
        }

    }
    public static void main(String[] args) {
        Student student1 = new Student(1,2,3,4);
        Student student2 = new Student(2,3,4,5);
        Student student3 = new Student(3,4,5,4);
        student1.less(student2);
        student2.less(student3);
        student1.less(student3);
    }
}

