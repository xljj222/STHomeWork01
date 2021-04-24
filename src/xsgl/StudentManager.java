package xsgl;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections; 
import java.util.Comparator;
import xsgl.Student;

public class StudentManager {

	    public  void app(ArrayList<Student> array) {

	    	
	        while (true) {
	          
	            System.out.println("��ѡ�������");
	            System.out.println("************************************");
	            System.out.println("*             1 ����                                             *");
	            System.out.println("*             2 ����                                             *");
	            System.out.println("*             3 ɾ��                                             *");
	            System.out.println("*             4 �޸�                                             *");
	            System.out.println("*             5 ���                                             *");
	            System.out.println("*             6 �˳�                                             *");
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
                    System.out.println("ллʹ��,�˳�ϵͳ�ɹ�");
                    //break;
                    System.exit(0); }
	        }//JVM�˳�
            
        }
	    public static void addStudent(ArrayList<Student> array) {
	        
	        Scanner sc = new Scanner(System.in);
     int id;
	        while(true){
	            System.out.println("������ѧ��ѧ�ţ�");
	             id = sc.nextInt();
	            boolean flag = isUsed(array, id);
	            if (flag) {
	                System.out.println("�������ѧ���Ѿ���ռ�ã�����������");
	            } 
	            else {
	                break;
	            }
	        }

	        System.out.println("������ѧ��������");
	        String name = sc.next();
	        System.out.println("������ѧ���������ڣ�");
	        String birDate = sc.next();
	        System.out.println("������ѧ���Ա�");
	        boolean gender = sc.nextBoolean();
	        Student s = new Student();
	        s.setId(id);
	        s.setName(name);
	        s.setbirDate(birDate);
	        s.setGender(gender);
	        array.add(s);
	        //Student.sort(comparing(Student::getId));
	        System.out.println("���ѧ���ɹ�");
	        
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
			 System.out.println("�������ѧ��������");
			 String name = sc.next();
			 int index=-1;
		        for (int i = 0; i < array.size(); i++) {
		            Student s = array.get(i);
		            if (s.getName().equals(name)) {
		            	index=i;
		            	System.out.println("ѧ�ţ�"+array.get(i).getId());
		            	System.out.println("������"+array.get(i).getName());
		            	System.out.println("�������ڣ�"+array.get(i).getbirDate());
		            	System.out.println("�Ա�"+array.get(i).getGender());          
		                break;	} 
		            }
		 if(index==-1){
	            System.out.println("����Ϣ�����ڣ�����������");
	        }
		 }
		
	    public static void deleteStudent(ArrayList<Student> array) {
	        
	        Scanner sc = new Scanner(System.in);

	        System.out.println("��������Ҫɾ����ѧ����������");
	        String Gname = sc.next();
	        int index=-1;
	        //�������Ͻ���Ӧѧ������Ӽ�����ɾ��
	        for (int i = 0; i < array.size(); i++) {
	            Student s = array.get(i);
	            if (s.getName().equals(Gname)) {
	                index=i;
	                break;
	            }
	        }
	        if(index==-1){
	            System.out.println("����Ϣ�����ڣ�����������");
	        }
	        else{
	            array.remove(index);
	            //����ɾ���ɹ���ʾ
	            System.out.println("ɾ���ɹ�");
	        }
	    }
	    public static void updateStudent(ArrayList<Student> array) {
	              @SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
	        System.out.println("��������Ҫ�޸ĵ�ѧ��������");
	        String Gname = sc.next();
	        int flag=-1;
	        if(array.size()==0){
	        	System.out.println("û��ѧ��");
	        }
	        else{
	        	for(int i=0;i<array.size();i++){
	        		Student a=array.get(i);
	        		if(Gname.equals(a.getName())){
	        			flag=i;
	        		}
	        		if(flag!=-1){
	        			//����¼��Ҫ�޸ĵ�ѧ����Ϣ
	        	        System.out.println("������ѧ����ѧ��");
	        	        int id = sc.nextInt();
	        	        System.out.println("������ѧ��������");
	        	        String name= sc.next();
	        	        System.out.println("������ѧ���³�������");
	        	        String birDate = sc.next();
	        	        System.out.println("������ѧ�����Ա�");
	        	        boolean gender = sc.nextBoolean();

	        	        //����ѧ������
	        	        Student s = new Student();
	        	        s.setId(id);
	        	        s.setName(name);
	        	        s.setbirDate(birDate);
	        	        s.setGender(gender);
	        	        System.out.println("�޸�ѧ���ɹ�");
	        	        array.set(flag,s);
	        		}
	        		else{
	        			System.out.println("û�����ѧ��");
	        			break;
	        		}
	        	}
	        } 
	    }

	    //����һ�����������ڲ鿴ѧ����Ϣ
	    public static void findAllStudent(ArrayList<Student> array) {
	        //�жϼ������Ƿ������ݣ����û����ʾ��ʾ��Ϣ
	        if (array.size() == 0) {
	            System.out.println("����Ϣ�����������Ϣ�ٲ�ѯ");
	            
	            return;
	        }

	        //��ʾ��Ϣ
	        System.out.println("ѧ��\t����\t��������\t�Ա�");
	        for (int i = 0; i < array.size(); i++) {
	            Student s = array.get(i);
	            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getbirDate() + "\t" + s.getGender());
	        }
	    }
	    }
	


