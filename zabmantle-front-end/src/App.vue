<script setup>
  import {ref} from "vue";

  const word = ref('안녕')

  const submit = () => {
    fetch(`/api/zabmantle/${word.value}`)
      .then(res => res.json())
      .then(console.log)
  }
</script>

<template>
  <form @submit.prevent="submit">
    <input type="text" v-model="word">
    <button>추측하기</button>
  </form>

  <ul>
    <li>a</li>
    <li>b</li>
    <li>c</li>
  </ul>
</template>
