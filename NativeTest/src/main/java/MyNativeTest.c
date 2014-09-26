#include <jni.h>
#include <stdio.h>
#include "MyNativeTest.h"
JNIEXPORT void JNICALL Java_MyNativeTest_sayHello(JNIEnv *env, jobject obj){
    printf("Hello");
    return;
}
JNIEXPORT jint JNICALL Java_MyNativeTest_summa(JNIEnv *env, jobject obj, jint a, jint b){
	return a+b;
};