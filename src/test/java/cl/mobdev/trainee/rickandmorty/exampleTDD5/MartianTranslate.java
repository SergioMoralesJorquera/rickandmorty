package cl.mobdev.trainee.rickandmorty.exampleTDD5;

import org.springframework.stereotype.Component;

@Component //es parecido al bean, disponible en spring para ser inyectado en cualquier clase
public class MartianTranslate {

    private String phrasesF="";
    char letter;

    public String execute(String names){

        if ("" != names){
            String [] phrases= names.split(" ");
            String finalPhrases = phrases[0]+phrases[1];

            for (int i=0;i<finalPhrases.length();i++) {
                letter = finalPhrases.charAt(i);

                switch (letter) {

                    case 'a':
                        letter = '1';
                        break;

                    case 'e':
                        letter = '2';
                        break;

                    case 'i':
                        letter = '3';
                        break;

                    case 'o':
                        letter = '4';
                        break;

                    case 'u':
                        letter = '5';
                        break;
                }

                phrasesF = phrasesF + letter;
            }

        }

        return phrasesF;
    }
}
