import java.math.BigInteger
import kotlin.math.max

fun firstMissingPositive(nums: IntArray): Int {
	if(nums.size==1){
		if(nums[0]==1)return 2
		else return 1
	}
	for (i in 0 until nums.size - 1) {
		for (j in 0 until nums.size - i - 1) {
			if (nums[j] > nums[j + 1]) {
				// swap arr[j] and arr[j + 1]
				val temp = nums[j]
				nums[j] = nums[j + 1]
				nums[j + 1] = temp
			}
		}
	}
	var maxVal=nums[nums.size-1]
	maxVal=max(maxVal,nums.size)
	for (i in 1 .. maxVal){
		var missed=1
		for (j in i-1 until nums.size){
			if(i==nums[j]){
				missed=0
				break
			}
		}
		if(missed==1) return i
	}
	return maxVal+1
}
fun main() {
	val nums = intArrayOf(1,2,0)
	println(firstMissingPositive(nums))
	val nums1 = intArrayOf(3,4,-1, 1)
	println(firstMissingPositive(nums1))
	val nums2 = intArrayOf(7,8,9,11,12)
	println(firstMissingPositive(nums2))
}