package com.app;

import com.app.entity.BlackList;
import com.app.entity.Post;
import com.app.entity.User;
import com.app.service.BlackListService;
import com.app.service.PostService;
import com.app.service.UserService;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.app.service")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.app.repos")
@EntityScan("com.app.entity")
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    
    @Autowired
    BlackListService blackService;
     
    Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        //SpringApplication.run(SpringConsoleApplication.class, args);
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
            mainMenu();

    }

    public void mainMenu() {
        int p = 0;
        scanner.reset();
        System.out.println();
        do {
            System.out.println("1) таблиця User ");
            System.out.println("2) таблиця Post ");
            System.out.println("3) таблиця BlackList ");
            System.out.println("4) Завершити роботу ");
            System.out.print("Оберіть пункт меню: ");
            p = scanner.nextInt();
             scanner.nextLine();
            //p = textIO.newIntInputReader().withMinVal(1).read("Оберіть пункт меню: ");
        } while (p > 4 || p <= 0);
        switch (p) {
            case 1:
                userMenu();
                break;
            case 2:
                postMenu();
                break;
            case 3:
                blockMenu();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

  
    public void userMenu() {
        
        scanner.reset();
        System.out.println();
        int p = 0;
         do {
            System.out.println("1) додати  користувача ");
            System.out.println("2) пошук користувача ");
            System.out.println("3) видалити користувача ");
            System.out.println("4) вивести всіх користувачів ");
            System.out.println("5) оновити останню активність користувача ");
            System.out.println("6) повернутись в головне меню ");
                System.out.print("Оберіть пункт меню: ");
            p = scanner.nextInt();
             scanner.nextLine();
              //p =  textIO.newIntInputReader()            .withMinVal(1)            .read("Оберіть пункт меню: ");
         }while(p>6 || p<=0);
        switch (p) {
            case 1:
                createUser();
                userMenu();
                break;
            case 2:
                searchUserById();
                userMenu();
                break;
            case 3:
                deleteUserById();
                userMenu();
                break;
            case 4:
                printUsers();
                userMenu();
                break;
            case 5:
                updateUserById();
                userMenu();
                break;
            case 6:
                mainMenu();
                break;
        }
    }
    
    
     public void postMenu() {
        
        scanner.reset();
        System.out.println();
        int p = 0;
         do {
            System.out.println("1) додати  пост ");
            System.out.println("2) пошук поста по ID ");
            System.out.println("3) видалити пост ");
            System.out.println("4) видалити всі пости користувача по ID");
            System.out.println("5) вивести всі пости ");
            System.out.println("6) вивести всі пости користувача по ID");
            System.out.println("7) повернутись в головне меню ");
                System.out.print("Оберіть пункт меню: ");
            p = scanner.nextInt();
             scanner.nextLine();
              //p =  textIO.newIntInputReader()            .withMinVal(1)            .read("Оберіть пункт меню: ");
         }while(p>7 || p<=0);
        switch (p) {
            case 1:
                createPost();
                postMenu();
                break;
            case 2:
                searchPostById();
                postMenu();
                break;
            case 3:
                deletePostById();
                postMenu();
                break;
            case 4:
                deletePostByUserId();
                postMenu();
                break;
            case 5:
                printPosts();
                postMenu();
                break;
            case 6:
                searchPostsUserById();
                postMenu();
                break;
            case 7:
                mainMenu();
                break;
        }
    }
    
    
      public void blockMenu() {
        
        scanner.reset();
        System.out.println();
        int p = 0;
         do {
            System.out.println("1) вивести заблокованих користувачів ");
            System.out.println("2) заблокувати користувача ");
            System.out.println("3) розблокувати користувача ");
            System.out.println("4) повністю розблокувати користувача ");
            System.out.println("5) повернутись в головне меню ");
                System.out.print("Оберіть пункт меню: ");
            p = scanner.nextInt();
             scanner.nextLine();
              //p =  textIO.newIntInputReader()            .withMinVal(1)            .read("Оберіть пункт меню: ");
         }while(p>5 || p<=0);
        switch (p) {
            case 1:
                printBlockedUsers();
                blockMenu();
                break;
            case 2:
                blockUser();
                blockMenu();
                break;
            case 3:
                unblockUser();
                blockMenu();
                break;
                
            case 4:
                unblockUserFull();
                blockMenu();
                break;    

            case 5:
                mainMenu();
                break;
        }
    }
    public void createUser(){
        scanner.reset();
        User user = new User();
        System.out.print("Введіть нік ");
        String nickName =  scanner.next();
        System.out.print("Посилання на фото ");
        String photo = scanner.next();
        user.setNickName(nickName);
        user.setFoto(photo);
        user.setLastActivity(new Date());
        
        userService.createUser(user);

        
    }
    
     public void createPost(){
         User user = new User();
         Scanner scanner = new Scanner(System.in);
           System.out.print("Введіть ID користувача:  ");
           int id =  scanner.nextInt();//textIO.newIntInputReader()            .withMinVal(1)            .read("Введіть ID користувача: ");
            user = userService.getUserById(id);
           
              if(true) {
                  Scanner scanUpdate = new Scanner(System.in);
              System.out.print("Введіть опис ");
              String temp = scanUpdate.nextLine();
              Post post = new Post();
              post.setDescription(temp);
              post.setPostType(1);
              post.setDate(new Date());
              postService.createPost(user,post);
              }

    }
     
     public void searchPostById(){
           scanner.reset();
           System.out.print("Введіть ID поста:  ");
           int id =  scanner.nextInt();//textIO.newIntInputReader()            .withMinVal(1)            .read("Введіть ID користувача: ");
            scanner.nextLine();
           Post post = postService.getPostById(id);
           if (post!=null){
               printPost(post);
           }
           else {
               System.out.println("Пост не знайдено");
           }
           
    }
      public void searchPostsUserById(){
            scanner.reset();
           System.out.print("Введіть ID користувача:  ");
           int id =  scanner.nextInt();//textIO.newIntInputReader()            .withMinVal(1)            .read("Введіть ID користувача: ");
            scanner.nextLine();
           User user = userService.getUserById(id);
           if (user!=null){
               for(Post post :postService.getPostsByUser(user)){
                   printPost(post);
               }
           }
           else {
               System.out.println("Користувач не знайдено");
           }
           
    }
    
    public void searchUserById(){
            scanner.reset();
             System.out.println();
           System.out.print("Введіть ID користувача:  ");
           int id =  scanner.nextInt();//textIO.newIntInputReader()            .withMinVal(1)            .read("Введіть ID користувача: ");
            scanner.nextLine();
           User user = userService.getUserById(id);
           if (user!=null){
               printUsers();
           }
           else {
               System.out.println("Користувач не знайдено");
           }
           
           
   }
    
    
    public void updateUserById(){
          scanner.reset();
           System.out.println();
           System.out.print("Введіть ID користувача:  ");
           int id =  scanner.nextInt();
            scanner.nextLine();
          //int id = textIO.newIntInputReader()            .withMinVal(1)            .read("Введіть ID користувача: ");
          
           User user = userService.getUserById(id);
           if (user!=null){
               user.setLastActivity(new Date());
               userService.update(user,id);
           }
           else {
               System.out.println("Користувач не знайдено");
           }
           
   }
    
    public void deleteUserById(){
           scanner.reset();
            System.out.println();
           System.out.print("Введіть ID користувача:  ");
           int id =  scanner.nextInt();
            scanner.nextLine();
          //int id = textIO.newIntInputReader()           .withMinVal(1)            .read("Введіть ID користувача: ");
           User user = userService.getUserById(id);
           if (user!=null){
               userService.deleteUser(id);
           }
           else {
               System.out.println("Користувач не знайдено");
           }
           
    }
    
    public void blockUser(){
         scanner.reset();
          System.out.println();
         System.out.print("Введіть ID користувача що блокують:  ");
         int idL =  scanner.nextInt();
         System.out.print("Введіть ID користувача що блокує:  ");
         int idB =  scanner.nextInt();
         
         User userB = userService.getUserById(idB);
         User userL = userService.getUserById(idL);
         
         if (userL==null){
             System.out.println(String.format("Користувач ID %d не знайдений",idL));
             return;
         }
         if (userB==null){
             System.out.println(String.format("Користувач ID %d не знайдений",idB));
             return;
         }
         blackService.blockUser(userL, userB);
         
    }
    
    public void unblockUser(){
         scanner.reset();
          System.out.println();
         System.out.print("Введіть ID користувача якого заблокували:  ");
         int idL =  scanner.nextInt();
         System.out.print("Введіть ID користувача який блокував:  ");
         int idB =  scanner.nextInt();
         User userB = userService.getUserById(idB);
         
         if (userB==null){
             System.out.println(String.format("Користувач ID %d не знайдений",idB));
             return;
         }
         User userL = userService.getUserById(idL);
         if (userL==null){
             System.out.println(String.format("Користувач ID %d не знайдений",idL));
             return;
         }
         blackService.unblockUser(userL, userB);
         
    }
    public void unblockUserFull(){
         scanner.reset();
          System.out.println();
         System.out.print("Введіть ID користувача якого заблокували:  ");
         int idL =  scanner.nextInt();

         User userL = userService.getUserById(idL);
         
         if (userL==null){
             System.out.println(String.format("Користувач ID %d не знайдений",idL));
             return;
         }
        
         blackService.unblockUserFull(userL);
         
    }

    
    public void deletePostById(){
         scanner.reset();
          System.out.println();
           System.out.print("Введіть ID поста:  ");
           int id =  scanner.nextInt();
            scanner.nextLine();
          //int id = textIO.newIntInputReader()           .withMinVal(1)            .read("Введіть ID користувача: ");
           Post post = postService.getPostById(id);
           if (post!=null){
               postService.deletePost(post);
           }
           else {
               System.out.println("Пост не знайдено");
           }
           
             
    }
    
     public void deletePostByUserId(){
         scanner.reset();
          System.out.println();
           System.out.print("Введіть ID користувача:  ");
           int id =  scanner.nextInt();
            scanner.nextLine();
          //int id = textIO.newIntInputReader()           .withMinVal(1)            .read("Введіть ID користувача: ");
           User user = userService.getUserById(id);
           if (user!=null){
              postService.deletePostByUser(user);
           }
           else {
               System.out.println("Користувач не знайдено");
           }
           
         }
    public void printUser(User user){
        
         System.out.printf("Користувач ID %d, нік  %s, фото %s, остання активність %tc \n", user.getUserId(), user.getNickName(), user.getFoto(), user.getLastActivity());
    }
    
     public void printPost(Post post){
         System.out.printf("Пост ID %d, опис %s користувач %s[%d], створено %tc \n", post.getPostId(), 
                 post.getDescription(),
                 post.getUser().getNickName(),
                 post.getUser().getUserId(),
                 post.getDate());
    }
    
    public void printUsers(){
        List<User> list =userService.getAll();
        if (list!=null && list.size()>0){
        for(User user:list){
            printUser(user);
        }
        }
        else 
        {
            System.out.println("Користувачів не знайдено!");
        }
        
        
    }
    
    public void printBlockedUsers(){
        List<BlackList> list  =  blackService.getBlackList();
        for (BlackList b :list){
            System.out.printf("Користувач %s заблокований %s  %tc \n", 
                    b.getLockingUser().getNickName(),
                    b.getLockingUser().getUserId(),
                    b.getLockingTime());
        }
            }
    
    public void printPosts(){
        List<Post> list =postService.getAll();
        if (list!=null && list.size()>0){
        for(Post post:list){
            printPost(post);
        }
        }
        else 
        {
            System.out.println("Постів не знайдено!");
        }
      
        
    }
    

}
