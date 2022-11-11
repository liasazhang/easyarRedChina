# easyarRedMoveChina

基于easyar技术、opengles技术、轮播图播放视频播放、伪橙光游戏的安卓app

### 运行截图
![image](https://user-images.githubusercontent.com/87653158/201338649-31578f9b-6ee3-4ed9-9990-ad659f30ceff.png)
![image](https://user-images.githubusercontent.com/87653158/201338788-ba423b89-f62d-4ad6-be14-883dbc2f60ba.png)
![image](https://user-images.githubusercontent.com/87653158/201338824-205d5945-2942-48e0-9257-2c4a20751fd3.png)

### 游戏界面截图
暂时还未找到橙光小游戏嵌入安卓的方法，只能先用图片跳转来实现
![image](https://user-images.githubusercontent.com/87653158/201338911-49990580-5c69-4d4d-9c82-abbc062c8721.png)

### ar识别ui图
调用的easyar官方的包，摄像头也未采用安卓原生，easyar提供了接口，这里并未用到云识别，因为图片少，官网提供无限次的本地easyar调用，后期可以试试稠密矩阵等玩法。
这里写的逻辑是识别到对应图片，通过图片的英文名称判断那张图片，跳转到相关界面。官方给的是直接在表面粘连一个彩色方块，是用的opengl编写的，不是很会改，头秃~
![image](https://user-images.githubusercontent.com/87653158/201339126-db458ced-0d44-470b-993a-fd4afe237c9b.png)

### 轮播图找了很久，banner包总是找不到正确可运行的，最后找到一个banner放入安卓本地调用运行的。
