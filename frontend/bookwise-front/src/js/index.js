const apiElastic = "http://localhost:8080";

function requestBooksByTitle(title){
    const data = fetch(apiElastic + "/api/books/" + title);
    const results = data.json();
    return results.hits;
}