package com.galvanize;

public class ZipCodeProcessor {

    private final Verifier verifier;

    public ZipCodeProcessor(Verifier verifier) {
        this.verifier = verifier;
    }

    public void process(String zipCode) {
        try{
        verifier.verify(zipCode);
        System.out.println("Thank you! Your package will arrive soon.");
        }
        catch (Exception e){
            if (e.getMessage().equals("ERRCODE 21: INPUT_TOO_LONG")){
                System.out.println("The zip code you entered was the wrong length.");
            }if (e.getMessage().equals("ERRCODE 22: INPUT_TOO_SHORT")){
                System.out.println("The zip code you entered was the wrong length.");
            }if (e.getMessage().equals("ERRCODE 27: NO_SERVICE")){
                System.out.println("We're sorry, but the zip code you entered is out of our range.");
            }
        }
    }

    public static void main(String[] args) {
        Verifier verifier = new Verifier();
        ZipCodeProcessor processor = new ZipCodeProcessor(verifier);
        processor.process("80302");
        processor.process("2345678");
        processor.process("321");
        processor.process("12234");
    }
}
