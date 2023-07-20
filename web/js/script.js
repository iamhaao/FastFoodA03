// Open the default tab
document.getElementById("description").style.display = "block";

function openTab(event, tabName) {
  // Hide all tab content
  var tabcontent = document.getElementsByClassName("tabcontent");
  for (var i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }

  // Remove 'active' class from all tab links
  var tablinks = document.getElementsByClassName("tablinks");
  for (var i = 0; i < tablinks.length; i++) {
    tablinks[i].classList.remove("active");
  }

  // Display the clicked tab content and set the tab link as active
  document.getElementById(tabName).style.display = "block";
  event.currentTarget.classList.add("active");
}

function submitReview(event) {
  event.preventDefault();

  // Get form values
  var name = document.getElementById("name").value;
  var rating = document.getElementById("rating").value;
  var review = document.getElementById("review").value;
  var image = document.getElementById("image").value;


  // Clear form values
  document.getElementById("name").value = "";
  document.getElementById("rating").value = "";
  document.getElementById("review").value = "";

  // Create review element
  var reviewElement = document.createElement("p");
  reviewElement.innerHTML = "<strong>" + name + "</strong> - " + rating + " stars<br>" + review;

  // Add review to review list
  document.getElementById("review-list").appendChild(reviewElement);
}
