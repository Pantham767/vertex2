function filterTable() {
    // Get user-entered cost range
    var minCost = parseFloat(document.getElementById("filterColumn1").value);
    var maxCost = parseFloat(document.getElementById("filterColumn2").value);

    // Variable to check if any row is within the cost range
    var anyRowVisible = false;

    // Loop through table rows
    for (var i = 1; i <= 4; i++) { // Assuming you have 4 rows, adjust accordingly
      var row = document.getElementById("row" + i);

      // Get cost from the row (replace 'costCell' with the actual cell containing the cost)
      var costCell = row.cells[5]; // Assuming cost is in the 6th column, adjust accordingly
      var cost = parseFloat(costCell.textContent.trim());

      // Show/hide row based on cost range
      if (cost >= minCost && cost <= maxCost) {
        row.style.display = "";
        anyRowVisible = true;
      } else {
        row.style.display = "none";
      }
    }

    // If no rows are within the cost range, display an empty message or table
    if (!anyRowVisible) {
      document.getElementById("tableContainer").innerHTML = "<p>No matching results found.</p>";
    }
  }

  // Function to handle form submission
  function submitForm(event) {
    // Prevent the default form submission
    event.preventDefault();

    // Assuming you have a form with the ID 'interestForm'
    var form = document.getElementById("interestForm");

    // Perform form submission logic here

    // Display success notification
    Swal.fire({
      icon: 'success',
      title: 'Success!',
      text: 'Form submitted successfully!',
    }).then((result) => {
      // Redirect to another page after clicking 'OK'
      if (result.isConfirmed) {
        window.location.href = 'another_page.html'; // Replace with the desired page URL
      }
    });
  }
  function submitForm() {
    // Your form submission logic goes here

    // Show a popup message
    alert("Form submitted successfully!");
    
    // Close the modal if you have one
    $('#interestModal').modal('hide');
  }
  document.addEventListener("DOMContentLoaded", function () {
    // Set the interval to update the card-deck transform property
    setInterval(function () {
      let cardDeck = document.querySelector("#card-slider .card-deck");
      cardDeck.style.transform = "translateX(-100%)";
      setTimeout(function () {
        cardDeck.appendChild(cardDeck.firstElementChild);
        cardDeck.style.transform = "translateX(0)";
      }, 1000); // Transition duration in milliseconds
    }, 5000); // Interval between slides in milliseconds
  });
  