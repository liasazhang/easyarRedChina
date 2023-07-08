![image](https://github.com/liasazhang/easyarRedChina/assets/87653158/ad4bb7ed-04f3-4afe-9721-4b6a5fc25739)# easyarRedMoveChina

基于easyar技术、opengles技术、轮播图播放视频播放、伪橙光游戏的安卓app

### 运行截图
![image](https://github.com/liasazhang/easyarRedChina/assets/87653158/a46131b3-ac45-4282-8e63-ff29b30ee37d)
![image](https://github.com/liasazhang/easyarRedChina/assets/87653158/f3634f0f-ac0a-4059-839f-e3d434fd4772)

![image](https://github.com/liasazhang/easyarRedChina/assets/87653158/966f6b1a-c117-4748-8345-2d7d640e78bf)


### 游戏界面截图
暂时还未找到橙光小游戏嵌入安卓的方法，只能先用图片跳转来实现
![image](https://user-images.githubusercontent.com/87653158/201338911-49990580-5c69-4d4d-9c82-abbc062c8721.png)

### 运行视频


https://github.com/liasazhang/easyarRedChina/assets/87653158/b89910ec-32df-4f2e-87ec-10f3fe78599f


### ar识别ui图
调用的easyar官方的包，摄像头也未采用安卓原生，easyar提供了接口，这里并未用到云识别，因为图片少，官网提供无限次的本地easyar调用，后期可以试试稠密矩阵等玩法。
这里写的逻辑是识别到对应图片，通过图片的英文名称判断那张图片，跳转到相关界面。官方给的是直接在表面粘连一个彩色方块，是用的opengl编写的，不是很会改，头秃~
![image](https://user-images.githubusercontent.com/87653158/201339126-db458ced-0d44-470b-993a-fd4afe237c9b.png)

### 轮播图找了很久，banner包总是找不到正确可运行的，最后找到一个banner放入安卓本地调用运行的。
