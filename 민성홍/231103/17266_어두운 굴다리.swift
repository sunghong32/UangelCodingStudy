//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/11/03.
////  백준 17266: 어두운 굴다리
////  메모리: 87288 KB
////  시간: 88 ms

import Foundation

var N = Int(readLine()!)!
var M = Int(readLine()!)!
var location = readLine()!.split(separator: " ").map{Int(String($0))!}

func check() {
    var left = 0
    var right = N
    var mid = 0
    var answer = 0
    while(left <= right){
        mid = (left + right) / 2
        if (isAllShine(height: mid)){
            answer = mid
            right = mid - 1
        }else{
            left = mid + 1
        }
    }
    print(answer)
}

func isAllShine(height : Int) -> Bool {
    var lightCount = 0

    for streetLampIndex in location {
        if streetLampIndex - height <= lightCount {
            lightCount = streetLampIndex + height
        }else{
            return false
        }
    }
    if lightCount >= N {
        return true
    }else{
        return false
    }
}

check()
