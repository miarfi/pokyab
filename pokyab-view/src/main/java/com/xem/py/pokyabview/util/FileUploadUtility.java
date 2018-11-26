package com.xem.py.pokyabview.util;


import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.BasicLogger;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author arria
 */
public class FileUploadUtility {
    
    private static final BasicLogger logger = LoggerFactory.logger(FileUploadUtility.class);
    private static final String ABS_PATH = "D:\\Miguel_Arriaga\\Dropbox\\IDE\\netbeans82\\pokyab\\pokyab-view\\src\\main\\webapp\\assets\\images\\";
    private static String REAL_PATH = "";


    public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
        //
        REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
        logger.info(ABS_PATH);
        logger.info(REAL_PATH);

        if (!new File(ABS_PATH).exists()) {
            new File(ABS_PATH).mkdirs();
        }
        if (!new File(REAL_PATH).exists()) {
            new File(REAL_PATH).mkdirs();
        }
        try {
            file.transferTo(new File(REAL_PATH + code + ".jpg"));
            file.transferTo(new File(ABS_PATH + code + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
