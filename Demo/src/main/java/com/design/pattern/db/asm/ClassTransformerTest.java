package com.design.pattern.db.asm;

import org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM4;
import static jdk.internal.org.objectweb.asm.Opcodes.INVOKESTATIC;

public class ClassTransformerTest {
    public static void main(String[] args) throws Exception {
        ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("com/design/pattern/db/asm/Tank.class")
        );

        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC, "com/design/pattern/db/asm/TankProxy", "before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };

        cr.accept(cv, 0);
        byte[] bytes = cw.toByteArray();

        MyClassLoader cl = new MyClassLoader();
        cl.loadClass("com.design.pattern.db.asm.TankProxy");
        Class cb = cl.defineClass("com.db.asm.Tank", bytes);
        cb.getConstructor().newInstance();

        String path = (String) System.getProperties().get("user.dir");
        File file = new File(path + "/com/design/pattern/db/asm/");
        file.mkdirs();

        FileOutputStream fos = new FileOutputStream(new File(path + "/com/design/pattern/db/asm/Tank_0.class"));
        fos.write(bytes);
        fos.flush();
        fos.close();
    }
}
