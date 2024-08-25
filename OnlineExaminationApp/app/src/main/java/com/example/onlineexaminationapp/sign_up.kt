package com.example.onlineexaminationapp

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {

    private lateinit var fullNameInput: TextInputLayout
    private lateinit var usernameInput: TextInputLayout
    private lateinit var emailInput: TextInputLayout
    private lateinit var passwordInput: TextInputLayout
    private lateinit var studentButton: Button
    private lateinit var facultyButton: Button
    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize views
        fullNameInput = findViewById(R.id.material1)
        usernameInput = findViewById(R.id.material)
        emailInput = findViewById(R.id.materialEmail)
        passwordInput = findViewById(R.id.material21)
        studentButton = findViewById(R.id.button)
        facultyButton = findViewById(R.id.button2)
        signUpButton = findViewById(R.id.button3)

        // Set onClickListeners
        studentButton.setOnClickListener {
            // Load Student Sign-Up Form
            Toast.makeText(this, "Fill the Student Sign-Up Form", Toast.LENGTH_SHORT).show()
            showStudentForm()
        }

        facultyButton.setOnClickListener {
            // Load Faculty Sign-Up Form
            Toast.makeText(this, "Fill the Faculty Sign-Up Form", Toast.LENGTH_SHORT).show()
            showFacultyForm()
        }

        signUpButton.setOnClickListener {
            // Validate input fields
            if (validateInputs()) {
                Toast.makeText(this, "Congrats! You signed up!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showStudentForm() {
        // Custom logic if needed to modify form for students
    }

    private fun showFacultyForm() {
        // Custom logic if needed to modify form for faculty
    }

    private fun validateInputs(): Boolean {
        val fullName = fullNameInput.editText?.text.toString().trim()
        val username = usernameInput.editText?.text.toString().trim()
        val email = emailInput.editText?.text.toString().trim()
        val password = passwordInput.editText?.text.toString().trim()

        // Validate Full Name
        if (TextUtils.isEmpty(fullName)) {
            fullNameInput.error = "Full Name is required"
            return false
        } else {
            fullNameInput.error = null
        }

        // Validate Username
        if (TextUtils.isEmpty(username)) {
            usernameInput.error = "Username is required"
            return false
        } else {
            usernameInput.error = null
        }

        // Validate Email
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.error = "Invalid Email Address"
            return false
        } else {
            emailInput.error = null
        }

        // Validate Password
        if (TextUtils.isEmpty(password)) {
            passwordInput.error = "Password is required"
            return false
        } else {
            passwordInput.error = null
        }

        return true
    }
}
