func checkIfPrerequisite(numCourses int, prerequisites [][]int, queries [][]int) []bool {
    

    g:=make([][]bool,numCourses)


    for i:=0; i < numCourses;i++{
        g[i]=make([]bool,numCourses)
    }

    for _,e:=range prerequisites{
        g[e[0]][e[1]]=true
    }

    for k:=0; k < numCourses;k++{

        for i:=0; i< numCourses;i++{

            for j :=0 ; j < numCourses;j++{

                if g[i][k] && g[k][j] {
                    g[i][j]=true
                }
            }
        }
    }

    res := make([]bool, 0)

    for _,e :=range queries{

        res=append(res,g[e[0]][e[1]])
    }

    return res


}