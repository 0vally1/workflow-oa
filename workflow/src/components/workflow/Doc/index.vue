<template>
  <div>
    <svg-icon icon-class="question" @click="goto" />
  </div>
</template>

<script>
export default {
  name: 'workflowDoc',
  data() {
    return {
      url: 'http://doc.workflow.vip/workflow'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
