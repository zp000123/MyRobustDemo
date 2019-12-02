package com.example.myrobustdemo;

import android.content.Context;
import android.os.Environment;

import com.meituan.robust.Patch;
import com.meituan.robust.PatchManipulate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PatchManipulateImp extends PatchManipulate {
    @Override
    protected List<Patch> fetchPatchList(Context context) {
        // 将 app 自己的 robustApkHash 上报给服务端，服务端根据 robustApkHash 来区分每一次 apk build
        // 来给 app 下发补丁
        Patch patch = new Patch();
        patch.setName("123");
        // 下面的robust 是生成补丁后，存在手机的robust 文件夹中。如果你改成qwe ，生产的补丁就放在 qwe 中。
        // 所以部署 jar 包到手机的时候，相关的adb命令参数和这里要对应上。
        patch.setLocalPath(Environment.getExternalStorageDirectory().getPath() + File.separator
                + "robust" + File.separator + "patch.jar");
        patch.setTempPath(Environment.getExternalStorageDirectory().getPath() + File.separator
                + "robust" + File.separator + "patch");
        patch.setPatchesInfoImplClassFullName("com.example.myrobustdemo.PatchesInfoImpl");
        List patches = new ArrayList();
        patches.add(patch);
        return patches;
    }

    @Override
    protected boolean verifyPatch(Context context, Patch patch) {
        return true;
    }

    @Override
    protected boolean ensurePatchExist(Patch patch) {
        return true;
    }
}
