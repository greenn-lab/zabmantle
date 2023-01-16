<script setup lang="ts">
import { computed } from 'vue'
import { handleBackground } from '../layoutHandler'

const props = defineProps({
  image: {
    type: String,
  },
  class: {
    type: String,
  },
})

const style = computed(() => handleBackground(props.image))
</script>

<template>
  <div class="grid grid-flow-col auto-col-max w-full h-full auto-rows-fr">
    <div class="slidev-layout default" :class="props.class">
      <slot />
    </div>
    <div class="w-full w-full" :style="style" />
  </div>
</template>
