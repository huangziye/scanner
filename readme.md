[![](https://jitpack.io/v/huangziye/scanner.svg)](https://jitpack.io/#huangziye/scanner)

# Add ` scanner ` to project

- Step 1：Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```android
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

- Step 2：Add the dependency

The latest version shall prevail.

```android
dependencies {
        implementation 'com.github.huangziye:scanner:${latest_version}'
}
```

# usage:

```java
private final String[] perms = {Manifest.permission.CAMERA};

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.btn_open_camera).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), 100);
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, perms, 100);
            }
        }
    });
}

@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), 100);
    }
}

@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (100 == requestCode && resultCode == Activity.RESULT_OK) {
        Toast.makeText(MainActivity.this, data.getStringExtra(CaptureActivity.RESULT_DATA_KEY), Toast.LENGTH_SHORT).show();
    }
}
```



# About me


- [简书](https://user-gold-cdn.xitu.io/2018/7/26/164d5709442f7342)

- [掘金](https://juejin.im/user/5ad93382518825671547306b)

- [Github](https://github.com/huangziye)


# License

```
Copyright 2018, huangziye

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```