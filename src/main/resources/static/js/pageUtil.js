
function makePages(page,size,totalPage){
    console.log(page,size,totalPage)

    const startNum = (Math.ceil(page/10)*10)-9
    console.log("startNum : " , startNum)
    let result = " "

    //이전
    if(startNum !== 1){
      result += `<li class="page-item"><a class="page-link" href="${startNum - 1}">&laquo;</a></li>`
    }


    let temp = startNum 

    while(true){

      if(temp * size > totalPage){
        break;
      }
      console.log(temp)

      result += `<li class="page-item"><a class="page-link" href="${temp}">${temp}</a></li>`

      temp++
    }
    
    //다음 
    if(totalPage%(size*10) === 1){
      result += `<li class="page-item"><a class="page-link" href="${startNum + 10}">&raquo;</a></li>`
    }

    console.log(result)

    return result
  }