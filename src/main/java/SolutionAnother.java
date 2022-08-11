/*
@可爱抱抱呀
执行用时：3 ms, 在所有 Java 提交中击败了85.11%的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了63.83%的用户
2022年8月9日 10:44
*/
class SolutionAnother {
    public String solveEquation(String equation) {
        String s[]=equation.split("=");
        int left[]=findCoefficient(s[0]),right[]=findCoefficient(s[1]);
        if(left[0]==right[0]){return left[1]==right[1]?"Infinite solutions":"No solution";}
        return "x="+(right[1]-left[1])/(left[0]-right[0]);
    }
    int[] findCoefficient(String t){
        int[] ans =new int[2];
        int sign=1,sum=0;
        char c[]=t.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]>='0'&&c[i]<='9'){
                while(i<c.length&&c[i]>='0'&&c[i]<='9'){
                    sum=sum*10+c[i]-'0';
                    i++;
                }
                if(i<c.length&&c[i]=='x'){ans[0]+=sign*sum;}
                else{
                    ans[1]+=sign*sum;
                    i--;
                }
                sum=0;
            }
            else if(c[i]=='-'){sign=-1;}
            else if(c[i]=='+'){sign=1;}
            else{ans[0]+=sign;}
        }
        return ans;
    }
}
