<template>
    <div id="register">
        <registered>
        </registered>
        <!-- <hello></hello> -->
        
    </div>
</template>

<script>
import 'common/css/reset.css';
import Registered from 'components/Login/Register'
export default {
    name: 'register',
    components: {
      Registered
    }
}
</script>

<style scoped>
#register{
    position: fixed;
    background-image: url(./images/bg.jpg);
    width: 100%;
    height: 100%;
    background-size: cover;
    background-position: center center;
    z-index: -999;
    text-align: center;
}
</style>
