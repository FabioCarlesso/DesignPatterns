package com.fabiocarlesso.state.packagestate;

import com.fabiocarlesso.state.Package;

public interface PackageState {
    void next(Package pkg);
    void prev(Package pkg);
    void printStatus();
}
