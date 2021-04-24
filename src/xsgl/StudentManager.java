package xsgl;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections; 
import java.util.Comparator;
import xsgl.Student;

public class StudentManager {

	    public  void app(ArrayList<Student> array) {

	    	
	        while (true) {
	          
	            System.out.println("请选择操作：");
	            System.out.println("************************************");
	            System.out.println("*             1 插入                                             *");
	            System.out.println("*             2 查找                                             *");
	            System.out.println("*             3 删除                                             *");
	            System.out.println("*             4 修改                                             *");
	            System.out.println("*             5 输出                                             *");
	            System.out.println("*             6 退出                                             *");
	            System.out.println("************************************");
	            Scanner sc = new Scanner(System.in);
	            String line = sc.nextLine();
	            switch (line) {
                case "1":              
                    addStudent(array);
                    break;
                case "2":
                    checkStudent(array);
                    break;
                case "3":
                	deleteStudent(array);
                    break;
                case "4":
                    updateStudent(array);
                	
                    break;
                case "5":
                	findAllStudent(array);
                	break;
                case"6":
                    System.out.println("谢谢使用,退出系统成功");
                    //break;
                    System.exit(0); }
	        }//JVM退出
            
        }
	    public static void addStudent(ArrayList<Student> array) {
	        
	        Scanner sc = new Scanner(System.in);
     int id;
	        while(true){
	            System.out.println("请输入学生学号：");
	             id = sc.nextInt();
	            boolean flag = isUsed(array, id);
	            if (flag) {
	                System.out.println("您输入的学号已经被占用，请重新输入");
	            } 
	            else {
	                break;
	            }
	        }

	        System.out.println("请输入学生姓名：");
	        String name = sc.next();
	        System.out.println("请输入学生出生日期：");
	        String birDate = sc.next();
	        System.out.println("请输入学生性别：");
	        boolean gender = sc.nextBoolean();
	        Student s = new Student();
	        s.setId(id);
	        s.setName(name);
	        s.setbirDate(birDate);
	        s.setGender(gender);
	        array.add(s);
	        //Student.sort(comparing(Student::getId));
	        System.out.println("添加学生成功");
	        
	        Collections.sort(array,new Comparator<Student>(){
	        	@Override
	        	public int compare(Student i1,Student i2){
	        		return i1.getId()-i2.getId();
	        	}
	        });

	    }
		public static boolean isUsed(ArrayList<Student> array, int id) {
	        
	            boolean flag = false;
	            for(int i=0; i<array.size(); i++) {
	                Student s = array.get(i);
	                if(s.getId()==(id)) {
	                    flag = true;
	                    break;
	                }
	            }
	            return flag;
	        }
		 public static void checkStudent(ArrayList<Student> array) {
			 Scanner sc = new Scanner(System.in);
			 System.out.println("输入查找学生姓名：");
			 String name = sc.next();
			 int index=-1;
		        for (int i = 0; i < array.size(); i++) {
		            Student s = array.get(i);
		            if (s.getName().equals(name)) {
		            	index=i;
		            	System.out.println("学号："+array.get(i).getId());
		            	System.out.println("姓名："+array.get(i).getName());
		            	System.out.println("出生日期："+array.get(i).getbirDate());
		            	System.out.println("性别："+array.get(i).getGender());          
		                break;	} 
		            }
		 if(index==-1){
	            System.out.println("该信息不存在，请重新输入");
	        }
		 }
		
	    public static void deleteStudent(ArrayList<Student> array) {
	        
	        Scanner sc = new Scanner(System.in);

	        System.out.println("请输入你要删除的学生的姓名：");
	        String Gname = sc.next();
	        int index=-1;
	        //遍历集合将对应学生对象从集合中删除
	        for (int i = 0; i < array.size(); i++) {
	            Student s = array.get(i);
	            if (s.getName().equals(Gname)) {
	                index=i;
	                break;
	            }
	        }
	        if(index==-1){
	            System.out.println("该信息不存在，请重新输入");
	        }
	        else{
	            array.remove(index);
	            //给出删除成功提示
	            System.out.println("删除成功");
	        }
	    }
	    public static void updateStudent(ArrayList<Student> array) {
	              @SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
	        System.out.println("请输入你要修改的学生的姓名");
	        String Gname = sc.next();
	        int flag=-1;
	        if(array.size()==0){
	        	System.out.println("没有学生");
	        }
	        else{
	        	for(int i=0;i<array.size();i++){
	        		Student a=array.get(i);
	        		if(Gname.equals(a.getName())){
	        			flag=i;
	        		}
	        		if(flag!=-1){
	        			//键盘录入要修改的学生信息
	        	        System.out.println("请输入学生新学号");
	        	        int id = sc.nextInt();
	        	        System.out.println("请输入学生新姓名");
	        	        String name= sc.next();
	        	        System.out.println("请输入学生新出生日期");
	        	        String birDate = sc.next();
	        	        System.out.println("请输入学生新性别");
	        	        boolean gender = sc.nextBoolean();

	        	        //创建学生对象
	        	        Student s = new Student();
	        	        s.setId(id);
	        	        s.setName(name);
	        	        s.setbirDate(birDate);
	        	        s.setGender(gender);
	        	        System.out.println("修改学生成功");
	        	        array.set(flag,s);
	        		}
	        		else{
	        			System.out.println("没有这个学生");
	        			break;
	        		}
	        	}
	        } 
	    }

	    //定义一个方法，用于查看学生信息
	    public static void findAllStudent(ArrayList<Student> array) {
	        //判断集合中是否有数据，如果没有显示提示信息
	        if (array.size() == 0) {
	            System.out.println("无信息，请先添加信息再查询");
	            
	            return;
	        }

	        //显示信息
	        System.out.println("学号\t姓名\t出生日期\t性别");
	        for (int i = 0; i < array.size(); i++) {
	            Student s = array.get(i);
	            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getbirDate() + "\t" + s.getGender());
	        }
	    }
	    }
	


