# 📧 Spring Boot Email Sending Integration

This is a Spring Boot application that allows users to save student records through a form and automatically sends a confirmation email using **Gmail SMTP**.

---

## 🚀 Features

- Web form to collect student details
- Save student data to a MySQL database
- Automatically send a confirmation email to the student after saving
- Simple, clean architecture using JavaMailSender

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring MVC + Thymeleaf
- Spring Data JPA (Hibernate)
- JavaMailSender (Gmail SMTP)
- MySQL

---

## 📂 Project Structure

src/ ├── controller/ │ └── StudentController.java ├── entity/ │ └── Student.java ├── repository/ │ └── StudentRepository.java ├── service/ │ ├── StudentService.java │ └── impl/ │ └── StudentServiceImpl.java └── resources/ ├── application.properties └── templates/ └── student-form.html

php-template
Copy
Edit

---

## 📦 Maven Dependencies

Add the following to your `pom.xml`:

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Thymeleaf -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>

    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Spring Boot Starter Mail -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-mail</artifactId>
    </dependency>
</dependencies>

```
⚙️ Configuration (application.properties)
properties
Copy
Edit
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/sendingmaildb
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update

# Gmail SMTP Configuration
```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
🔐 How to Get Gmail App Password
Important: Gmail blocks less secure app access by default. You must use an App Password.

Steps:
Go to: https://myaccount.google.com/security

Enable 2-Step Verification if not already enabled.

Click on App Passwords

Select:

App: Mail

Device: Other → Name it anything (e.g., "Spring App")

Click Generate

Copy the 16-digit app password and paste it into spring.mail.password in your application.properties.

📧 JavaMailSender Explanation
Spring Boot provides the JavaMailSender interface for sending emails. In this project, we use it like this:

java
```
@Autowired
private JavaMailSender javaMailSender;
```
It is automatically configured using the properties from application.properties. You can send a plain text email using SimpleMailMessage.

💡 Email Sending Logic Explained
Here's how the sendStudentEmail(Long id) method works:

```
public void sendStudentEmail(Long id) {
    Student student = getStudentById(id);  // Fetch student from DB
    if (student != null) {
        SimpleMailMessage message = new SimpleMailMessage(); // Create email message
        message.setTo(student.getEmail());                   // Recipient
        message.setSubject("Student Information");           // Subject
        message.setText("Hello " + student.getFirstName() + ",\nYour student record has been saved."); // Body
        javaMailSender.send(message);                        // Send email
    }
}
```
Whenever a student is saved, this method is automatically triggered to send an email with a greeting and confirmation.


▶️ How to Run the App
Clone the Repository

```
git clone <your-repo-url>
cd <project-folder>
//Build the Project
```
```
mvn clean package
```
Run the App


mvn spring-boot:run
Open Student Form Visit:
http://localhost:8080/students/form

Submit Form Once the form is submitted:

Student data is saved to the DB

Confirmation email is sent

✅ Notes
Ensure the sendingmaildb MySQL database exists.

You must be online when sending emails.

Don’t commit your Gmail credentials or app password to GitHub.

Use .gitignore to exclude application.properties or use environment variables.

🧑‍💻 Author
Made with ❤️ by Akanksha Mankar

Feel free to fork, contribute, or open issues!





