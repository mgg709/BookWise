<script>

</script>

<template>
    <!--header>
        <div class="image-container">
            <img :src="`src/assets/${imageName}.png`" alt="User profile img">
            <p>USERNAME</p>
        </div>
        <nav>
            <ul>
                <li><a title="Reviews" accesskey="R" tabindex="1" href="#section1">Reviews</a></li>
                <li><a title="Favourites" accesskey="V" tabindex="2" href="#section2">Favourites</a></li>
            </ul>
        </nav>
    </header-->
    <header>
  <div class="container">
    <div class="content">
      <div class="image-container">
        <img :src="`src/assets/${imageName}.png`" alt="User profile img">
        <p>USERNAME</p>
      </div>
    </div>
    <nav>
      <ul>
        <li><a title="Reviews" accesskey="R" tabindex="1" href="#section1">Reviews</a></li>
        <li><a title="Favourites" accesskey="V" tabindex="2" href="#section2">Favourites</a></li>
      </ul>
    </nav>
  </div>
</header>
</template>

<script>
    export default {
        name: "Profile",
        props: {
            imageName: {
                type: String,
                required: true
            }
        }
    }
</script>

<style>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.image-container {
  display: flex;
  align-items: center;
}

.image-container img {
    width: 15.625em;
    height: 15.625em;
}

.image-container p {
  margin-left: 10px; /* Espacio entre la imagen y el nombre de usuario */
}

nav {
  text-align: center;
  font-size: 18px; /* Tamaño de la fuente del menú de navegación */
  border-bottom: 2px solid orange; /* Línea debajo del menú */
  padding-bottom: 10px; /* Espacio entre el menú y la línea */
}

nav ul {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
  justify-content: center;
}

nav ul li {
  margin-right: 2.813em; /* Espacio entre los elementos de navegación */
  border-radius: 10%;
  background-color: orangered;
}

nav ul li:last-child {
  margin-right: 0; /* Elimina el margen derecho del último elemento */
}

nav ul li a{
    color: white;
}

</style>