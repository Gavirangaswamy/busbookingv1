const container = document.querySelector('.container');
const seats = document.querySelectorAll('.row .seat:not(.occupied');
const count = document.getElementById('count');
const total = document.getElementById('total');

bookedSeats();
let ticketPrice = document.getElementById('price').value;


// update total and count
function updateSelectedCount() {
  const selectedSeats = document.querySelectorAll('.row .seat.selected');

  const seatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat));

  console.log(ticketPrice);
  console.log(seatsIndex);


  const selectedSeatsCount = selectedSeats.length;
  const properSeatNumbers = seatsIndex.map(v=> v+1);
  const seatnumbers = JSON.stringify(properSeatNumbers);	
  count.innerText = selectedSeatsCount;
  total.innerText = selectedSeatsCount * ticketPrice;
  document.getElementById('totalcount').value =selectedSeatsCount;
  document.getElementById('totalamount').value=selectedSeatsCount * ticketPrice;
  document.getElementById('seatnum').value=seatnumbers;
 }
function bookedSeats() {
   const seat2 =document.getElementById('seats1').value;
  const selectedSeats = JSON.parse(seat2);
  const properSeatNumbers = selectedSeats.map(v=> v-1);
  if (properSeatNumbers !== null && properSeatNumbers.length > 0) {
    seats.forEach((seat, index) => {
      if (properSeatNumbers.indexOf(index) > -1) {
        seat.classList.add('occupied');
      }
    });
  }
}
// Seat click event
container.addEventListener('click', (e) => {
  if (e.target.classList.contains('seat') && !e.target.classList.contains('occupied')) {
    e.target.classList.toggle('selected');

    updateSelectedCount();
  }
});