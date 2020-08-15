package ir.javaclass.config;

public enum FileDelimiter {

    SLASH("/"),BACKSLASH("\\");
    private String delimiter;

    FileDelimiter(String delimiter){
        this.delimiter=delimiter;
    }

    @Override
    public  String toString(){
        return  delimiter;
    }

    public  int length(){
        return  delimiter.length();
    }

    public static FileDelimiter getSystemDelimiter(){
        if(System.getProperty("os.name").toLowerCase().contains("mac")){
            return SLASH;
        }
        else if (System.getProperty("os.name").toLowerCase().contains("win")){
            return BACKSLASH;
        }
        else if (System.getProperty("os.name").toLowerCase().contains("nix")||
                System.getProperty("os.name").toLowerCase().contains("linux")){
            return SLASH;
        }
        else if (System.getProperty("os.name").toLowerCase().contains("sunos")){
            return SLASH;
        }
        else{
            return null;
        }
    }
}
