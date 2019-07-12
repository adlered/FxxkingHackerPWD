# FxxkingHackerPWD
:lock: 对密码、字符串进行 打乱 | 加盐 | SHA1 加/解密，用于网站用户密码的验证&amp;&amp;存储，让宕出数据库的Hacker手足无措吧。

# 使用姿势
程序基本功能开发已经完成，完整的说明文档稍候会更新。

代码十分轻量，阅读`Test.java`中的几行源码即可掌握使用方法。

## 基本使用

### 注册
假设此时用户向后台发送了注册请求，其中密码为"123456"，我们可以调用下面的代码，将明文密码转换为"**哈希值SHA1**"和"**键值**"。其中，哈希值用于在用户登录时与用户输入的密码在通过处理后的哈希值进行比对，如果相同，则登录成功；键值用于和用户登录时输入的密码所配合，将密码进行还原和哈希值计算的处理：

```
PasswordPair passwordPair = CreatePWD.run("123456", 'Z', 'z');
```

`CreatePWD.run()`方法需要三个参数：

String password - 明文密码

char saltCode - 密码盐

char saltCode2 - 双重密码盐

其中，盐用于对密码进行进一步的混淆处理，你可以将两个盐值改成任意的单个字符，只要是char类型的即可。也可以直接使用我在上边填写的盐值。

`CreatePWD.run()`方法将会返回一个`PasswordPair`对象，这个对象中存储了加密后的哈希值和键值。你可以使用下面的命令分别显示两个值（存储至数据库）：

```
System.out.println(passwordPair.getStr() + "\n" + passwordPair.getKey());
```

这两个值对于之后的用户登录校验是十分重要的，我们后边会讲到。

### 登录

在数据库中存储了`CreatePWD.run()`方法所计算的哈希值和键值后，我们就可以对一串明文密码进行正确校验了。使用下方代码：

```
PasswordPair recovery = new PasswordPair("123456", {KEY});
```

其中，"123456"处应传入用户输入的密码，在{KEY}的位置调用你的数据库方法，填写用户在注册时生成的键值字符串。

然后，执行下方代码，计算用户输入的密码，配合注册时生成的键值，生成一个新的哈希值。如果这个新的哈希值与注册时生成的哈希值相同，即密码正确，登录成功：

```
String sha1 = "";
try {
    sha1 = AnalysisPWD.run(recovery, 'Z', 'z');
} catch (ArrayIndexOutOfBoundsException AIOFBE) {
	//由于算法特性，如果键值对应的字符串长度不正确，就会抛出错误（此时密码当然是不正确的，因为根本无法生成新密钥）。
    System.out.println("Wrong key!");
}
System.out.println(sha1);
if (passwordPair.getStr().equals(sha1)) {
	//密码正确
    System.out.println("Password correct!");
} else {
	//密码错误
    System.out.println("Wrong password!");
}
```

## 技术交流 && 技术支持
WeChat：1101635162

欢迎大佬 && 小白骚扰。
