//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Random;
//import java.sql.*;
//import java.util.*;
//
//public class Prepared_statement {
//
//        static String Alphabets = " abcdefghijklmnopqrstuvwxyz ";
//        static Random random = new Random();
//
//        public static String namerandom(){
//            StringBuilder sb = new StringBuilder(12);
//            for( int i = 0; i < 12; i++ )
//                sb.append( Alphabets.charAt( random.nextInt(Alphabets.length()) ) );
//            return sb.toString();
//        }
//
//        public static String addressrandom(){
//            StringBuilder sb = new StringBuilder(50);
//            for( int i = 0; i < 50; i++ )
//                sb.append( Alphabets.charAt( random.nextInt(Alphabets.length()) ) );
//            return sb.toString();
//        }
//
//        public static int semesterrandom(){
//            int semester = random.nextInt(8) + 1;
//            return semester;
//        }
//
//        public static int regnorandom(){
//            int reg = random.nextInt(999999) + 1;
//            return reg;
//        }
//
//        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//        static final String DB_URL = "jdbc:mysql://localhost/database_lab8";
//
//        //  Database credentials
//        static final String USER = "root";
//        static final String PASS = "root";
//
//        public static void main(String[] args) {
//            Connection conn = null;
//            PreparedStatement stmt = null;
//
//            try{
//                //STEP 2: Register JDBC driver
//                Class.forName("com.mysql.jdbc.Driver");
//
//                //STEP 3: Open a connection
//                System.out.println("Connecting to database...");
//                conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//                //STEP 4: Execute a query
//                System.out.println("Creating statement...");
//                int semester1;
//                String name1;
//                String address1;
//                int Reg1;
//                String sql = "insert into students values(?,?,?,?,?);" ;
//                stmt = conn.prepareStatement(sql);
//                conn.setAutoCommit(false);
//                long startTime = System.currentTimeMillis();
//                for(int i=0; i<5000;i++){
//                    semester1= semesterrandom();
//                    name1= namerandom();
//                    address1=addressrandom();
//                    Reg1=regnorandom();
//                    stmt.setString(1,name1);
//                    stmt.setInt(2,Reg1);
//                    stmt.setInt(3,semester1);
//                    stmt.setString(4,address1);
//                    stmt.setInt(5,i);
//                    stmt.executeUpdate();
//                }
//                conn.commit();
//
//                long stopTime = System.currentTimeMillis();
//                System.out.println(stopTime-startTime);
//
//
//                //STEP 6: Clean-up environment
//                stmt.close();
//                conn.close();
//            }catch(SQLException se){
//                //Handle errors for JDBC
//                se.printStackTrace();
//            }catch(Exception e){
//                //Handle errors for Class.forName
//                e.printStackTrace();
//            }finally{
//                //finally block used to close resources
//                try{
//                    if(stmt!=null)
//                        stmt.close();
//                }catch(SQLException se2){
//                }// nothing we can do
//                try{
//                    if(conn!=null)
//                        conn.close();
//                }catch(SQLException se){
//                    se.printStackTrace();
//                }//end finally try
//            }//end try
//            System.out.println("Goodbye!");
//        }//end main
//
//
//
//}
