function subscribe(){
  event.preventDefault();

  let headers = new Headers();

  headers.append('Content-Type', 'application/json');
  headers.append('Accept', 'application/json');
  headers.append('Access-Control-Allow-Origin', '*');

  fetch('https://ms-subscriber.herokuapp.com/subscribe', {
        mode: 'cors',
        body: JSON.stringify({ email: 'lolita@gmail.com' }),
        method: 'POST',
        headers: headers  
  })
    .then((response) => response.json())
    .then(json => {alert(json)})
    .catch((err) => console.log(err));
}