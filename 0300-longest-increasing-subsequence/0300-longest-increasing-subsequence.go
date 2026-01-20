func lengthOfLIS(nums []int) int {

    n:=len(nums)


    dp:=make([]int,n)


    for i:=0;i<n;i++{
        dp[i]=1;
    }
    
    ans:=1


    for i:=0;i<n;i++{
        for j:=0;j<i;j++{

            if nums[i]>nums[j] && dp[j]+1 > dp[i]{
                dp[i]=dp[j]+1
            }

        }
        ans=max(ans,dp[i])
    }

    return ans
}


func max( a int, b int) int {

    if a > b {
        return a
    }

    return b;
}