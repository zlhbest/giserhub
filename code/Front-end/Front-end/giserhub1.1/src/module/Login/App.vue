<template>
    <div id="login">
        <loginin>
        </loginin>
        <!-- <hello></hello> -->
        
    </div>
</template>

<script>
import 'common/css/reset.css';
import Loginin from 'components/Login/Login'
export default {
    name: 'login',
    components: {
      Loginin
    }
}
</script>

<style scoped>
#login{
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
