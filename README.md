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
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
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
Whenever a student is saved, this method is automatically triggered to send an email with a greeting and confirmation.

🔐 How to Get Gmail App Password
Google does not allow normal password login for SMTP. You must use an App Password.

Steps:

Go to https://myaccount.google.com/security

Turn on 2-Step Verification

Go to App Passwords

Choose Mail as the app and Other for the device

Generate and copy the password

Paste this password in your application.properties as spring.mail.password

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
Made with ❤️ by [Your Name]

Feel free to fork, contribute, or open issues!

yaml
Copy
Edit

---

Let me know if you'd like the `student-form.html` template or a working demo link included!






You said:
can you add this detals on readme file


ChatGPT said:
Absolutely! Here's the full README.md with the sendStudentEmail(Long id) method, explanation of JavaMailSender, Gmail SMTP setup, and everything integrated properly:

markdown
Copy
Edit
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
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
📧 JavaMailSender Overview
Spring Boot provides the JavaMailSender interface to send emails via SMTP.

You inject it into your service class:

java
Copy
Edit
@Autowired
private JavaMailSender javaMailSender;
It uses the configuration defined in application.properties.

📬 Email Sending Logic (Code)
Below is the method used to send a confirmation email after saving a student:

java
Copy
Edit
public void sendStudentEmail(Long id) {
    Student student = getStudentById(id);
    if (student != null) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(student.getEmail());
        message.setSubject("Student Information");
        message.setText("Hello " + student.getFirstName() + ",\nYour student record has been saved.");
        javaMailSender.send(message);
    }
}
🔍 What It Does:
Retrieves the student using the ID

Creates a SimpleMailMessage

Sets:

Recipient (student.getEmail())

Subject

Body message

Sends it using javaMailSender.send(message)

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

▶️ How to Run the App
1. Clone the Project
bash
Copy
Edit
git clone <your-repo-url>
cd <project-folder>
2. Build the Project
bash
Copy
Edit
mvn clean package
3. Run the Application
bash
Copy
Edit
mvn spring-boot:run
4. Open in Browser
bash
Copy
Edit
http://localhost:8080/students/form
Fill the form and submit — the data will be saved and an email will be sent!

✅ Notes
Ensure your MySQL database (sendingmaildb) exists.

You must be connected to the internet to send emails.

Use .gitignore to exclude application.properties from being pushed to GitHub.

You can use @Value("${spring.mail.username}") to inject config values securely.

🧑‍💻 Author
Made with ❤️ by [Your Name]

vbnet
Copy
Edit

Let me know if you'd like the HTML template for the form or want me to include screenshots!
