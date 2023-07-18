<template>
    <button class="btn">{{ textButton }} </button>
</template>

<script>
export default{
    name: "NormalButton",
    props:{
        textButton:{
            type: String,
            required: true
        },
    }, 
}
</script>
<style>
.btn {
  cursor: pointer;
  border: none;
  background: linear-gradient( to bottom, #ff9153, #eb5e28 );
  padding: 10px 20px;
  border-radius: 10px;
  color: white;
  box-shadow: 0px 3px 5px gray;
}

.btn:hover{
  background: linear-gradient( to bottom, #eb5e28, #ff9153 );
}

</style>