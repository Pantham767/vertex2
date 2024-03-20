document.addEventListener('DOMContentLoaded', function () {
    var createAccountForm = document.getElementById('createAccountForm');

    createAccountForm.addEventListener('submit', function (event) {
        event.preventDefault();

        // Your form validation logic here...
        
        var password = document.getElementById('password').value;
        var confirmPassword = document.getElementById('confirmPassword').value;

        var confirmPasswordMessage = document.getElementById('confirmPasswordMessage');
        
        if (password !== confirmPassword) {
            confirmPasswordMessage.innerText = "Password and Confirm Password must be the same!";
            return;
        } else {
            confirmPasswordMessage.innerText = "";
        }

        var isFormValid = true; // Replace this with your validation result
        if (isFormValid) {
            $('#successModal').modal('show');
        }
    });
});