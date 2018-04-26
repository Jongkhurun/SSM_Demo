package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 懒♂癌
 * @Create 2017-09-29 15:58
 */
/*@Configuration/*标识这个类可以使用Spring IoC容器作为bean定义的来源。@Bean注解告诉Spring，一个带有@Bean的注解方法将返回一个对象，该对象应该被注册为在Spring应用程序上下文中的bean。*/
/*@EnableAutoConfiguration/*能够自动配置spring的上下文，试图猜测和配置你想要的bean类，通常会自动根据你的类路径和你的bean定义自动配置。*/
/*@ComponentScan/*会自动扫描指定包下的全部标有@Component 的类，并注册成bean，当然包括@Component下的子注解@Service,@Repository,@Controller*/
@SpringBootApplication/*@Configuration,@EnableAutoConfiguration,@ComponentScan 统一注解*/
@ServletComponentScan/*扫描过滤器、拦截器、监听器、servlet*/
//@EnableCaching/*缓存支持*/
@EnableTransactionManagement/*事物支持*/
public class App {
    public static void main(String[] args) {
        System.out.println(
                "////////////////////////////////////////////////////////////////////\n" +
                        "//                          _ooOoo_                               //\n" +
                        "//                         o8888888o                              //\n" +
                        "//                         88\" . \"88                              //\n" +
                        "//                         (| ^_^ |)                              //\n" +
                        "//                         O\\  =  /O                              //\n" +
                        "//                      ____/`---'\\____                           //\n" +
                        "//                    .'  \\\\|     |//  `.                         //\n" +
                        "//                   /  \\\\|||  :  |||//  \\                        //\n" +
                        "//                  /  _||||| -:- |||||-  \\                       //\n" +
                        "//                  |   | \\\\\\  -  /// |   |                       //\n" +
                        "//                  | \\_|  ''\\---/''  |   |                       //\n" +
                        "//                  \\  .-\\__  `-`  ___/-. /                       //\n" +
                        "//                ___`. .'  /--.--\\  `. . ___                     //\n" +
                        "//              .\"\" '<  `.___\\_<|>_/___.'  >'\"\".                  //\n" +
                        "//            | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |                 //\n" +
                        "//            \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /                 //\n" +
                        "//      ========`-.____`-.___\\_____/___.-`____.-'========         //\n" +
                        "//                           `=---='                              //\n" +
                        "//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //\n" +
                        "//            佛祖保佑       永不宕机     永无BUG                 //\n" +
                        "////////////////////////////////////////////////////////////////////");
        System.out.println("开始启动");
        SpringApplication.run(App.class, args);
        System.out.println("启动成功");
    }
}
