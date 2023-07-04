<template>
    <button class="button--class" >
        <span class="tooltip">{{ textButton }}</span>
    </button>
</template>

<script>
export default{
    name: "Button",
    props:{
        textButton:{
            type: String,
            required: true
        }
    }
}
</script>