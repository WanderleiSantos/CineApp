package net.itinajero.app.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {

    public static List<String> getNextDays(int count){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date start = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, count);
        Date endDate = calendar.getTime();

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(start);
        List<String> nextDays = new ArrayList<String>();
        while (!gregorianCalendar.getTime().after(endDate)){
            Date d = gregorianCalendar.getTime();
            gregorianCalendar.add(Calendar.DATE, 1);
            nextDays.add(simpleDateFormat.format(d));
        }
        return nextDays;
    }
    public static String guardarImagem(MultipartFile multipartFile, HttpServletRequest httpServletRequest){

        String nomeOriginal = multipartFile.getOriginalFilename();
        nomeOriginal = nomeOriginal.replace(" ","-");
        String nomeFinal = randomAlphaNumeric(8)+nomeOriginal;

        String rootFinal = httpServletRequest.getServletContext().getRealPath("/resources/images/");
        try {
            File imageFile = new File(rootFinal + nomeFinal);
            multipartFile.transferTo(imageFile);
            return nomeFinal;
        }catch (IOException ex){
            return null;
        }
    }

    public static String randomAlphaNumeric(int count){
        String CARACTERES = "ABCDEFGHIJLMNOPQRSTUVXZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0){
            int caracter = (int) (Math.random()) * CARACTERES.length();
            builder.append(CARACTERES.charAt(caracter));
        }
        return builder.toString();
    }

}
