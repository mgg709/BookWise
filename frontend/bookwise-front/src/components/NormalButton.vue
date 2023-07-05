<template>
    <button>{{ textButton }} </button>
        <!-- <span class="tooltip">{{ textButton }}</span> -->
    
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
</style>