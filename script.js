// Section Navigation
function showSection(section) {
    document.getElementById("home").style.display = "none";
    document.getElementById("cart").style.display = "none";
    document.getElementById("profile").style.display = "none";
    document.getElementById(section).style.display = "block";
}

// Cart Functionality
let cart = [];

function addToCart(button) {
    let product = button.parentElement;
    let name = product.getAttribute("data-name");
    let price = parseInt(product.getAttribute("data-price"));

    cart.push({ name, price });
    updateCart();
}

function updateCart() {
    let cartItems = document.getElementById("cart-items");
    cartItems.innerHTML = "";
    let totalPrice = 0;

    cart.forEach((item, index) => {
        let div = document.createElement("div");
        div.innerHTML = `${item.name} - $${item.price} <button onclick="removeFromCart(${index})">Delete</button>`;
        cartItems.appendChild(div);
        totalPrice += item.price;
    });

    document.getElementById("total-price").innerText = totalPrice;
}

function removeFromCart(index) {
    cart.splice(index, 1);
    updateCart();
}

function checkout() {
    let total = document.getElementById("total-price").innerText;
    let userAmount = prompt(`Enter the amount to pay: (Total: $${total})`);

    if (parseInt(userAmount) === parseInt(total)) {
        alert("Order Placed Successfully!");
        cart = [];
        updateCart();
    } else {
        alert("Amount does not match the total!");
    }
}

// Profile Section
function enableEdit() {
    document.getElementById("first-name").disabled = false;
    document.getElementById("last-name").disabled = false;
    document.getElementById("email").disabled = false;
    document.getElementById("save-btn").style.display = "inline-block";
}

function saveProfile() {
    alert("Profile updated successfully!");
}
