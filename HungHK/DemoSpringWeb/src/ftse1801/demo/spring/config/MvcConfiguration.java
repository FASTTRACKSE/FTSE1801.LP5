//package ftse1801.demo.spring.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//import ftse1801.demo.spring.model.ISinhVienDAO;
//import ftse1801.demo.spring.model.SinhVienDAO;
// 
//@Configuration
//@ComponentScan(basePackages="ftse1801.demo.spring")
//@EnableWebMvc
//public class MvcConfiguration extends WebMvcConfigurerAdapter{
// 
//    @Bean
//    public ViewResolver getViewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/view/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
//     
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//    }
// 
//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost/quanly_sinhvien");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//         
//        return dataSource;
//    }
//     
//    @Bean
//    public SinhVienDAO getSinhVienDAO() {
//    	return new ISinhVienDAO(getDataSource());
//    }
//}