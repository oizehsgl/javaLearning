package org.oizehsgl.sub;

import lombok.Cleanup;
import org.junit.Test;

/**
 * @author oizehsgl
 * @since 3/13/23
 */
public class CleanupAnnotationTest {
    @Test
    public void testCleanup() {

        try {
            @Cleanup CleanupAnnotation cleanupAnnotation = new CleanupAnnotation();
            System.out.println(cleanupAnnotation);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (CleanupAnnotation cleanupAnnotation = new CleanupAnnotation()) {
            System.out.println(cleanupAnnotation);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CleanupAnnotation cleanupAnnotation = null;
        try {
            cleanupAnnotation = new CleanupAnnotation();
            System.out.println(cleanupAnnotation);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cleanupAnnotation != null) {
                try {
                    cleanupAnnotation.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}